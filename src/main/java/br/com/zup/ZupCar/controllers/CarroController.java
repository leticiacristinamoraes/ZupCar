package br.com.zup.ZupCar.controllers;

import br.com.zup.ZupCar.dtos.CarroDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @GetMapping("/fusca")
    public CarroDTO exibirFusca () {
        CarroDTO fusca = new CarroDTO("Fusca", "Azul", "mil", 1964);

        return fusca;
    }

    @GetMapping("/kombi")
    public CarroDTO exibirKombi () {
        CarroDTO kombi = new CarroDTO("Kombi", "Branca", "1.6", 1975);

        return kombi;
    }

}
