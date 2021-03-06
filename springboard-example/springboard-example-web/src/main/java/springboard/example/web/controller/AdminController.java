package springboard.example.web.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboard.example.model.AdminService;
import springboard.example.model.User;

import java.util.Date;

@RestController("/admin")
public class AdminController {

    private static Logger log = LoggerFactory.getLogger(AdminController.class);

    @Reference
    AdminService adminService;

    @GetMapping("users")
    public Object users(@RequestParam(name = "id", required = false) Long id,
                        @RequestParam(name = "status", required = false) User.Status status,
                        @RequestParam(name = "username", required = false) String username,
                        @RequestParam(name = "name", required = false) String name,
                        @RequestParam(name = "createdTime0", required = false) Date createdTime0,
                        @RequestParam(name = "createdTime1", required = false) Date createdTime1,
                        @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
                        @RequestParam(name = "pageSize", defaultValue = "20") int pageSize) {
        Page<User> result = adminService.findUsers(id, status, username, name, createdTime0, createdTime1, pageNum, pageSize);
        return result;
    }

}
