package kr.co.three.admin.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.three.admin.dto.adminDTO;
import kr.co.three.admin.service.adminServiceImpl;

@RestController
@RequestMapping("/admin")
public class adminController {

   @Autowired
   private BCryptPasswordEncoder bcryptPasswordEncoder;
   @Autowired
   private adminServiceImpl adminService;

////   가입 폼으로 이동
//   @GetMapping("/registerForm.do")
//   public String registerForm() {
//      return "admin/member/adminRegister";
//   }
//
////   로그인 폼으로 이동
//   @GetMapping("/loginForm.do")
//   public String loginForm() {
//      return "admin/main/adminMain";
//   }

////   관리자 등록
//   @PostMapping("/register.do")
//   public String register(adminDTO admin) {
//
//      admin.setMemberPhone("01012345678");
//      admin.setMemberType(0);
//
//      // 패스워드 암호화
//      String pwd = bcryptPasswordEncoder.encode(admin.getMemberPwd());
//      admin.setMemberPwd(pwd);
//
//      int result = adminService.registerAdmin(admin);
//
//      if (result == 1) {
//         return "admin/member/adminLogin";
//      } else {
//         return "common/error";
//      }
//   }

//   관리자 등록
   @PostMapping("/adminRegister")
   public ResponseEntity<?> register(@RequestBody adminDTO admin) {

      admin.setMemberPhone("01012345678");
      admin.setMemberType(0);

      // 패스워드 암호화
      String pwd = bcryptPasswordEncoder.encode(admin.getMemberPwd());
      admin.setMemberPwd(pwd);

      int result = adminService.registerAdmin(admin);

      if (result == 1) {
         return new ResponseEntity<>("success", HttpStatus.OK);
      } else {
         return new ResponseEntity<>("error", HttpStatus.OK);
      }
   }

////   아이디 중복검사
//   @PostMapping("/checkId.do")
//   @ResponseBody
//   public String checkId(String adminId) {
//
//      int result = adminService.checkId(adminId);
//
//      if (result == 1) {
//         return "duplication";
//      } else {
//         return "available";
//      }
//   }

//   아이디 중복검사
   @PostMapping("/adminCheckId")
   @ResponseBody
   public ResponseEntity<?> checkId(String adminId) {

      int result = adminService.checkId(adminId);

      if (result == 1) {
         return new ResponseEntity<>("success", HttpStatus.OK);
      } else {
         return new ResponseEntity<>("error", HttpStatus.OK);
      }
   }

////   로그인
//   @PostMapping("/login.do")
//   public String loginIndex(adminDTO admin, HttpSession session, Model model) {
//
//      adminDTO loginAdmin = adminService.loginAdmin(admin);
//
//      if (!Objects.isNull(loginAdmin)
//            && bcryptPasswordEncoder.matches(admin.getMemberPwd(), loginAdmin.getMemberPwd())
//            && loginAdmin.getMemberType() == 0) {
//
//         session.setAttribute("memberNo", loginAdmin.getMemberNo());
//         session.setAttribute("memberId", loginAdmin.getMemberId());
//         session.setAttribute("memberType", loginAdmin.getMemberType());
//
//         model.addAttribute("admin", admin);
//         return "admin/main/adminMain";
//      } else {
//         return "common/error";
//      }
//   }

//   로그인
   @PostMapping("/adminLogin")
   public ResponseEntity<?> loginIndex(@RequestBody adminDTO admin, HttpSession session) {

      adminDTO loginAdmin = adminService.loginAdmin(admin);

      if (!Objects.isNull(loginAdmin)
            && bcryptPasswordEncoder.matches(admin.getMemberPwd(), loginAdmin.getMemberPwd())
            && loginAdmin.getMemberType() == 0) {

         session.setAttribute("memberNo", loginAdmin.getMemberNo());
         session.setAttribute("memberId", loginAdmin.getMemberId());
         session.setAttribute("memberType", loginAdmin.getMemberType());

         Map<String, Object> response = new HashMap<>();
         response.put("admin", admin);

         return new ResponseEntity<>(response, HttpStatus.OK);
      } else {
         return new ResponseEntity<>("error", HttpStatus.OK);
      }
   }

////   로그아웃
//   @GetMapping("/logout.do")
//   public String logout(HttpSession session) {
//
//      session.removeAttribute("memberNo");
//      session.invalidate();
//
//      return "admin/member/adminLogin";
//   }
//
//}

//   로그아웃
   @GetMapping("/adminLogout")
   public ResponseEntity<?> logout(HttpSession session) {

      session.removeAttribute("memberNo");
      session.invalidate();

      return new ResponseEntity<>("success", HttpStatus.OK);
   }

}