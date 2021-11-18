package br.com.zup.ZupCar.carro;

import br.com.zup.ZupCar.carro.dtos.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<CarroDTO> exibirTodosCarros() {
        return carroService.exibirCarros();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCarro(@RequestBody CarroDTO carroDTO) {
        carroService.cadastrarCarro(carroDTO);
    }

    @GetMapping("/{nomeDoCarro}")
    public CarroDTO exibirCarro(@PathVariable String nomeDoCarro) {
       return carroService.buscarCarro(nomeDoCarro);
    }

    @PutMapping("/{nomeDoCarro}")
    @ResponseStatus(HttpStatus.OK)
    public CarroDTO atualizarCarro(@PathVariable String nomeDoCarro, @RequestBody CarroDTO carroDTO) {
        return carroService.atualizarCarro(nomeDoCarro, carroDTO);
    }

    /*@DeleteMapping("/{nomeDoCarro")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCarro(@PathVariable String nomeDoCarro) {
        for (CarroDTO carro : concessionaria) {
            if (carro.getModelo().equalsIgnoreCase(nomeDoCarro)) {
                concessionaria.remove(carro);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }*/
}
