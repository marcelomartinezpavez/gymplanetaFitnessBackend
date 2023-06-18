package com.gimnasio.planetaFitness.response;

import com.gimnasio.planetaFitness.dto.ClientDto;

import java.util.List;

public class ClientResponse {
    private List<ClientDto> clienteDtoList;

    public List<ClientDto> getClienteDtoList() {
        return clienteDtoList;
    }

    public void setClienteDtoList(List<ClientDto> clienteDtoList) {
        this.clienteDtoList = clienteDtoList;
    }
}
