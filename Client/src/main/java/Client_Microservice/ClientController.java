package Client_Microservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientRepository repository;

    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{idClient}")
    public Client getClientById(@PathVariable Integer idClient) {
        return repository.findById(idClient).orElseThrow();
    }

    @GetMapping
    public List<Client> all() {
        return repository.findAll();
    }

    @PostMapping
    public Client newClient(@RequestBody Client client) {
        return repository.save(client);
    }
}
