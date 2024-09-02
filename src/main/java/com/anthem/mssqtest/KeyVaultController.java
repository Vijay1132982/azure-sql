//package com.anthem.mssqtest;
//
//
//import com.anthem.dao.KeyVaultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class KeyVaultController {
//
//    private final KeyVaultService keyVaultService;
//
//    @Autowired
//    public KeyVaultController(KeyVaultService keyVaultService) {
//        this.keyVaultService = keyVaultService;
//    }
//
//    @GetMapping("/get-secret")
//    public String getSecret(@RequestParam String secretName) {
//    return keyVaultService.getSecretValue(secretName);
//}
//}
//
