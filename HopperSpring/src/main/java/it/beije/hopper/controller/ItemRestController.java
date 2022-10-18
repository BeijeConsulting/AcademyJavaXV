package it.beije.hopper.controller;

import it.beije.hopper.model.Item;
import it.beije.hopper.service.ItemServiceMod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "rest")
public class ItemRestController {

    @Autowired
    ItemServiceMod itemServiceMod;

    @GetMapping(value = "/item/{id}")
    public Item getItem(@PathVariable(name = "id") Integer id) {
        return itemServiceMod.findById(id);
    }

    @PostMapping(value = "/item/")
    public Item addItem(@RequestBody Item item) {
        return itemServiceMod.save(item);
    }

    @PutMapping(value = "/item/{id}")
    public Item updateItem(@PathVariable(name = "id") Integer id, @RequestBody Item newItem) {
        Item item = itemServiceMod.findById(id);
        if (newItem.getOrderId() == null) {
            newItem.setOrderId(item.getOrderId());
        }
        BeanUtils.copyProperties(newItem, item, "id");
        itemServiceMod.save(item);
        return item;
    }

    @DeleteMapping(value = "/item/{id}")
    public boolean deleteItem(@PathVariable(name = "id") Integer id) {
        return itemServiceMod.deleteItem(id);
    }
}
