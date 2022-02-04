package kz.mypro.mypro.service;

import kz.mypro.mypro.dto.PersonDto;
import kz.mypro.mypro.entity.QueryMsg;
import kz.mypro.mypro.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class DefaultPersonService implements PersonService{

    private final PersonRepository personRepository;

    @Override
    public void searchPersonByIin(String iin){
        QueryMsg queryMsg = new QueryMsg();
        queryMsg.setMsg_date(new Date());
        queryMsg.setMsg_type(1); // 1 - запроса, 2-ответ
        queryMsg.setMsg_status(1);
        queryMsg.setMsg_text(iin);

        personRepository.save(queryMsg);

    }
}
