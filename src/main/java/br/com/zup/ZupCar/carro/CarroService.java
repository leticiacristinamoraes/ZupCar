package br.com.zup.ZupCar.carro;

import br.com.zup.ZupCar.carro.dtos.CarroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {

    private List<CarroDTO> concessionaria = new ArrayList<>();

    public List<CarroDTO> exibirCarros() {
        return concessionaria;
    }

    public void cadastrarCarro(@RequestBody CarroDTO carroDTO){
        concessionaria.add(carroDTO);
    }

    public CarroDTO buscarCarro(String nomeDoCarro){
        for (CarroDTO carroReferencia : concessionaria) {
            if (carroReferencia.getModelo().equals(nomeDoCarro)) {
                return carroReferencia;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public CarroDTO atualizarCarro(String nomeDoCarro, CarroDTO carroDTO){
        CarroDTO carro = buscarCarro(nomeDoCarro);
        carro.setCor(carroDTO.getCor());
        carro.setMotor(carroDTO.getMotor());
        carro.setAno(carroDTO.getAno());

        return carro;
    }
}
