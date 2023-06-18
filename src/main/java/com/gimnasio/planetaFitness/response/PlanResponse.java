package com.gimnasio.planetaFitness.response;

import com.gimnasio.planetaFitness.dto.PlanDto;

import java.util.List;

public class PlanResponse {

    private List<PlanDto> planDtoList;

    public List<PlanDto> getProveedorDtoList() {
        return planDtoList;
    }

    public void setProveedorDtoList(List<PlanDto> proveedorDtoList) {
        this.planDtoList = planDtoList;
    }
}
