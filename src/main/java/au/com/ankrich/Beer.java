package au.com.ankrich;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by arichharia on 29/06/2016.
 */

@Entity
@Setter
@Getter
public class Beer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    public long id ;
    @Column
    public String name ;

}
