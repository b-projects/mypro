package kz.mypro.mypro.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "query_msg", schema = "dm")
@Data
@NoArgsConstructor

public class QueryMsg {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer msg_type;

    @Column
    private Integer msg_status;

    @Column
    private Integer msg_id;

    @Column
    private Date msg_date;

    @Column
    private String msg_result;

    @Column
    private String msg_text;

}
