package br.com.zup.ZupCar.controllers;

import br.com.zup.ZupCar.dtos.CarroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    private List<CarroDTO> concessionaria = new ArrayList<>();

    @GetMapping
    public List<CarroDTO> exibirTodosCarros() {
        return concessionaria;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCarro(@RequestBody CarroDTO carroDTO) {
        concessionaria.add(carroDTO);
    }

    @GetMapping("/{nomeDoCarro}")
    public CarroDTO exibirCarro(@PathVariable String nomeDoCarro) {
        for (CarroDTO carroReferencia : concessionaria) {
            if (carroReferencia.getModelo().equals(nomeDoCarro)) {
                return carroReferencia;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{nomeDoCarro}")
    @ResponseStatus(HttpStatus.OK)
    public CarroDTO atualizarCarro(@PathVariable String nomeDoCarro, @RequestBody CarroDTO carroDTO ) {
        CarroDTO carroObjeto = null;
        for (CarroDTO carroReferencia : concessionaria) {
            if (carroReferencia.getModelo().equals(nomeDoCarro)) {
                carroObjeto = carroReferencia;
            }
        }
        if (carroObjeto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado!");
        }
        carroObjeto.setCor(carroDTO.getCor());
        carroObjeto.setMotor(carroDTO.getMotor());
        carroObjeto.setAno(carroDTO.getAno());

        return carroObjeto;
    }
}
