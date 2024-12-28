package com.example.mantenimiento;

import com.example.mantenimiento.Entities.Pieza;
import com.example.mantenimiento.Entities.TipoPieza;
import com.example.mantenimiento.Repositories.TipoPiezaRepository;
import com.example.mantenimiento.Services.TipoPiezaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class MantenimientoApplication {

    private static final Logger log = LoggerFactory.getLogger(MantenimientoApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(MantenimientoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(TipoPiezaRepository repository, TipoPiezaService service) {
        return (args) -> {
            // save a few customers
            //repository.save(new TipoPieza("Sensores"));
            repository.save(new TipoPieza("Chapa"));





            // fetch an individual customer by ID
            List<Pieza> p = service.findPiezasByTipoId(102L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(p.toString());
            log.info("");
            log.info("--------------------------------");
            service.findAllTipoPiezas().forEach(tipo -> { log.info(tipo.toString());
            });





        };
    }
}
