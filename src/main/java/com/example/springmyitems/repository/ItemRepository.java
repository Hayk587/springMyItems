package com.example.springmyitems.repository;


import com.example.springmyitems.entity.Item;
import com.example.springmyitems.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {

//ete petqe useri sax haytarautyunner@

    List<Item> findAllByUser(User user);

}
