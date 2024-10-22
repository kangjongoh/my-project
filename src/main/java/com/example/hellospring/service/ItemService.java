package com.example.hellospring.service;

import com.example.hellospring.domain.Item;
import com.example.hellospring.dto.ItemDto;
import com.example.hellospring.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void saveItem(ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setCount(itemDto.getCount());

        itemRepository.save(item);
    }
    public ItemDto findItemById(Long id) {
        Item item = itemRepository.findById(id);

        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setCount(item.getCount());

        return itemDto;
    }

    public List<ItemDto> findAllItem() {
        return itemRepository.findAll()
                .stream()
                .map(item -> {
                    ItemDto itemDto = new ItemDto();
                    itemDto.setId(item.getId());
                    itemDto.setName(item.getName());
                    itemDto.setCount(item.getCount());

                    return itemDto;
                })
                .toList();
    }

    public void updateItemById(Long id, ItemDto itemDto) {
        Item findItem = itemRepository.findById(id);
        findItem.setName(itemDto.getName());
        findItem.setCount(itemDto.getCount());

        itemRepository.updateById(id, findItem);
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }
}
