
import com.bigbang.sushil.Unistudent;
import javax.persistence.Column;
import javax.persistence.Entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author The BigBang
 */
@Entity
public class ITNerds extends Unistudent {
      @Column (name = "Prisadasdasdce")
    String name;
    
    
    public String getIt() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setIt(String name) {
        this.name = name;
    }
    
    
    
}
