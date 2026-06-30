/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.KRS;
import dao.KRSDAO;
import java.util.List;
/**
 *
 * @author Henryy
 */
public class KRSController {
    private KRSDAO krsdao = new KRSDAO();
    
    public int create(KRS krs){
        return krsdao.create(krs);
    }
    public List<KRS>getKrs(){
        return krsdao.getKRS();
    }
    public int update(KRS krs, String nim){
        return krsdao.update(krs, nim);
    }
    public int delete(String nim){
        return krsdao.delete(nim);
    }
//    public int delete(String nim){
//        return krsdao.delete(nim);
//    }
}
