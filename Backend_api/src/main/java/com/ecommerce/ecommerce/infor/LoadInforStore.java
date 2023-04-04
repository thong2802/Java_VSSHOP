package com.ecommerce.ecommerce.controller.infor;

import com.ecommerce.ecommerce.model.Store;
import com.ecommerce.ecommerce.payload.reponse.LoadStore;
import com.ecommerce.ecommerce.payload.reponse.MessageResponse;
import com.ecommerce.ecommerce.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/store")
public class LoadInforStore {
    private final StoreRepository storeRepository;
    @GetMapping("/manage/info/load")
    public ResponseEntity<?> loadStoreInfo(@RequestParam String id) {
        Store store = storeRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("load account manage info: account is not existed " + id));
        if (store == null) {
            return ResponseEntity.ok().body(new MessageResponse(false, "load account manage info: account is not existed"));
        }else {
            return ResponseEntity.ok().body(new LoadStore(
                    store.getId(),
                    store.getLogo(),
                    store.getName(),
                    store.getEmail(),
                    store.getPhone(),
                    store.getAddress(),
                    "load store manage info: success"));
        }
    }
}
