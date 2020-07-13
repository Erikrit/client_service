//package org.olservice.config.controller;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.impl.TextCodec;
//import org.eclipse.microprofile.openapi.annotations.tags.Tag;
//import org.olservice.config.Swagger;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//
//@Tag(ref = "token")
//@Path(Swagger.Token)
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
//public class TokenController {
//
//    @POST
//    @Path("/gerarToken")
//        public String generetToken (DTOUsuarioToken dtoUsuarioToken) {
//            String jwtStr = Jwts.builder()
//                    .setSubject("TokemOlservice")
//                    .setHeaderParam("type", "jwt")
//                    .claim("nome", dtoUsuarioToken.getNome())
//                    .signWith(
//                            SignatureAlgorithm.HS256,
//                            TextCodec.BASE64.decode(
//                                    dtoUsuarioToken.getSenha()
//                            ))
//                    .compact();
//            return jwtStr;
//        }
//
//}
