package demo.controller;

import demo.model.Pro;
import demo.service.cate.ICateService;
import demo.service.pro.IProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProController {
    @Autowired
    private IProService proService;
    @Autowired
    private ICateService cateService;

    @GetMapping
    public ResponseEntity<Iterable<Pro>> showListPro() {
        List<Pro> product = (List<Pro>) proService.findAll();
        if (product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pro> createPro(@RequestBody Pro pro) {
        return new ResponseEntity<>(proService.save(pro), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pro> findById(@PathVariable Long id) {
        Optional<Pro> proOptional = proService.findById(id);
        if (!proOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(proOptional.get(), HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pro> editPro(@PathVariable Long id, @RequestBody Pro pro) {
        Optional<Pro> proOptional = proService.findById(id);
        if (!proOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pro.setId(proOptional.get().getId());
        return new ResponseEntity<>(proService.save(pro), HttpStatus.OK);
    }

    @GetMapping("/search/{value}")
    public ResponseEntity<Iterable<Pro>> findByName(@PathVariable String value) {
        return new ResponseEntity<>(proService.findAllByNameContaining("%" + value + "%"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pro> deleteBlog(@PathVariable Long id) {
        Optional<Pro> pro = proService.findById(id);
        if (!pro.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        proService.remove(id);
        return new ResponseEntity<>(pro.get(), HttpStatus.NO_CONTENT);
    }
}

