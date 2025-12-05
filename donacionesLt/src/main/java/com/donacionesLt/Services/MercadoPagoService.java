package com.donacionesLt.Services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donacionesLt.Repositorios.DonacionRepositorio;
import com.donacionesLt.Repositorios.InstitucionRepositorio;
import com.donacionesLt.entities.Donacion;
import com.donacionesLt.entities.Institucion;
import com.fasterxml.jackson.databind.JsonNode;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.merchantorder.MerchantOrderClient;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.merchantorder.MerchantOrder;
import com.mercadopago.resources.preference.Preference;

@Service
public class MercadoPagoService {

  @Autowired
  DonacionRepositorio donacionRepositorio;

  @Autowired
  InstitucionRepositorio  institucionRepositorio;


  public void checkPayment(String paymentUuid, Long merchantId) throws MPException, MPApiException{
    MerchantOrderClient merchantOrderClient = new MerchantOrderClient();
    MerchantOrder order = merchantOrderClient.get(merchantId);
    Optional<Donacion> donacionOpt = donacionRepositorio.findByUuid(paymentUuid);
    if ( donacionOpt.isPresent() && order.getExternalReference().equals(paymentUuid)) {
      Donacion donacion= donacionOpt.get();
      String paymentStatus = order.getOrderStatus();
      if ( paymentStatus.equals("paid") ) {
        Date fechaPago = new Date();
        donacion.setPagado(true);
        donacion.setFechaPago( fechaPago );
      }

      donacionRepositorio.save(donacion);
    }
    System.out.println(order);
  }

  public boolean paymentNotification(String paymentUuid, JsonNode payload) throws MPException, MPApiException{
    JsonNode topic = payload.get("topic");

    if ( topic.isTextual() && topic.asText().equals("merchant_order")) {
      JsonNode resource = payload.get("resource");
      String link = resource.asText();
      String[] linkParts = link.split("/");
      long id = Long.parseLong(linkParts[linkParts.length - 1]);
      checkPayment(paymentUuid, id);
    }

    return true;
  }

  public String generatePaymentUrl(String paymentId, int price, Integer idInstitucion) throws MPException, MPApiException {

    PreferenceBackUrlsRequest backUrls =

        PreferenceBackUrlsRequest.builder()
            .build();

        Institucion institucion = institucionRepositorio.getById(idInstitucion);


        MercadoPagoConfig.setAccessToken(institucion.getPrivateToken());

          
            //tego que buscar la institucion y ahi poer el token

    PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
        .title("Donación a la Institución " + institucion.getNombre())
        .quantity(1)
        .currencyId("ARS")
        .unitPrice(new BigDecimal(price))
        .build();

    List<PreferenceItemRequest> items = new ArrayList<>();

    items.add(itemRequest);
    PreferenceRequest preferenceRequest = PreferenceRequest.builder()
        .items(items)
        .externalReference(paymentId)
        .notificationUrl("http://104.251.222.158:140023/mercadopago/notification/" + paymentId) // No borrar ni descomentar.
        .backUrls(backUrls)
        .build();

    PreferenceClient client = new PreferenceClient();

    Preference preference = client.create(preferenceRequest);

    return preference.getInitPoint();
  }
}

