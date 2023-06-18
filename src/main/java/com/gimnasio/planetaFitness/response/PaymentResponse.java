package com.gimnasio.planetaFitness.response;

import com.gimnasio.planetaFitness.dto.PaymentsDto;

import java.util.List;

public class PaymentResponse {

    private List<PaymentsDto> paymentDtoList;

    public List<PaymentsDto> getPaymentDtoList() {
        return paymentDtoList;
    }

    public void setPaymentDtoList(List<PaymentsDto> paymentDtoList) {
        this.paymentDtoList = paymentDtoList;
    }
}
