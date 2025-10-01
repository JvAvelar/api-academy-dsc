package vitoravelar.academy.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vitoravelar.academy.dto.LoginDTO;
import vitoravelar.academy.dto.TokenDTO;
import vitoravelar.academy.dto.UserDTO;
import vitoravelar.academy.models.User;
import vitoravelar.academy.repository.UserRepository;
import vitoravelar.academy.security.JwtTokenProvider;
import vitoravelar.academy.security.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthController(AuthenticationManager authenticationManager,PasswordEncoder passwordEncoder,
                          UserRepository userRepository, JwtTokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody LoginDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwt = tokenProvider.generateToken(userDetails);

        return ResponseEntity.ok(new TokenDTO(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Nome de usuário já está em uso!");
        }

        User newUser = new User(userDTO);
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(newUser);
        return ResponseEntity.ok("User registered successfully");
    }
}


