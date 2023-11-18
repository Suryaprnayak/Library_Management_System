package com.example.firstproject.Controller;

import com.example.firstproject.Modules.Admin;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("Admin")
public class AdminController {
    private final HashMap<Integer, Admin> adminMap = new HashMap<>();

    @PostMapping("/add_admin")
    public String addAdmin(@RequestBody Admin admin) {
        adminMap.put(admin.getId(), admin);
        return "Admin added Successfully";
    }

    @GetMapping("/get_admin")
    public List<Admin> getAdmin(){
        return new ArrayList<>(adminMap.values());
//        List<Admin> ans = new ArrayList<>();
//        for(int adminId : adminMap.keySet()){
//            System.out.println(adminMap.get(adminId));
//            ans.add(adminMap.get(adminId));
//        }
//        return ans;
    }
    @GetMapping("/get_Admin_By_name")
    public Admin getAdminByName(@RequestParam String name){
        for(int key : adminMap.keySet()){
            if (adminMap.get(key).getName().equals(name)) {
               return adminMap.get(key);
            }
        }
        return null;
    }
    @GetMapping("/get_admin_by_id")
    public Admin getAdminById(@RequestParam int id){
        return adminMap.get(id);
    }
    @DeleteMapping("/remove-Admin")
    public String removeAdmin(@RequestParam int id){
        if (adminMap.containsKey(id)){
            adminMap.remove(id);
            return "Admin remove successfully";
        }
        else {
            return "Admin not found";
        }
    }
    @PutMapping("/update_Admin-name")
    public String updateAdminName(@RequestParam int id,@RequestParam String name){
        Admin admin=adminMap.get(id);
        admin.setName(name);
        adminMap.put(id,admin);
        return "Admin updated successfully";
    }
}
