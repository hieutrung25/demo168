package demo.controller;

import demo.model.Cate;
import demo.service.cate.ICateService;
import demo.service.pro.IProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin("*")
public class CateController {
    @Autowired
    private ICateService cateService;
    @Autowired
    private IProService proService;

    @GetMapping
    public ResponseEntity<Iterable<Cate>> findAllCate() {
        List<Cate> category = (List<Cate>) cateService.findAll();
        if (category.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}