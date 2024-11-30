 
package com.example.demo; 
 
import java.util.List; 
import java.util.NoSuchElementException; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController; 
 
@RestController 
public class AppController { 
  
 @Autowired 
 MobileManager manager; 
  
 @GetMapping("/mobile") 
 public List<Mobile> listAllMobile() { 
  return manager.getAllMobile(); 
 } 
 
 @GetMapping("/mobile/{id}") 
 public ResponseEntity getMobile(@PathVariable Long id) { 
  try { 
   Mobile mobile = manager.getMobileById(id); 
   return new 
ResponseEntity<Mobile>(mobile,HttpStatus.OK); 
   } 
   catch(NoSuchElementException e) { 
    return new 
ResponseEntity<Mobile>(HttpStatus.NOT_FOUND); 
   } 
 } 
  
 @PostMapping("/mobile") 
 public void saveMobile(@RequestBody Mobile mobile) { 
  manager.saveMobile(mobile); 
 } 

  
 @PutMapping("/mobile") 
 public void updateMobile(@RequestBody Mobile mobile) { 
  manager.saveMobile(mobile);  
 } 
  
  
 //Using <Mobile> Template for ResponseEntity is Optional here 
 @DeleteMapping("/mobile/{id}") 
 public ResponseEntity<Mobile> deleteMobile (@PathVariable Long 
id) { 
   
  if(manager.exists(id)) 
  { 
   manager.deleteMobile(id);  
   return new ResponseEntity<Mobile>(HttpStatus.OK); 
  } 
  else { 
   return new 
ResponseEntity<Mobile>(HttpStatus.NOT_FOUND); 
  } 
 }  
}