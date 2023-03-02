package kz.mypro.mypro.service;

import kz.mypro.mypro.entity.QueryMsg;
import kz.mypro.mypro.generated.FindPersonRequest;
import kz.mypro.mypro.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXB;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.Date;

@Service
@AllArgsConstructor
public class DefaultPersonService implements PersonService{

    private PersonRepository personRepository;

    @Override
    public void searchPersonByIin(String iin){

        String filename = "request.xml";
        QueryMsg queryMsg = new QueryMsg();


        FindPersonRequest findPersonRequest = new FindPersonRequest();
        findPersonRequest.setIin(iin);

        StringWriter swrequest = new StringWriter();
        JAXB.marshal(findPersonRequest, swrequest);

        queryMsg.setMsg_date(new Date());
        queryMsg.setMsg_type(1); //  Тип запроса: 1 - запрос, 2-ответ
        queryMsg.setMsg_status(1); // Статус запроса: 1-На отправку
        queryMsg.setMsg_text(swrequest.toString());

        try {
            FileOutputStream fileOutputStream =new FileOutputStream(new File(filename));
            byte[] buffer = swrequest.toString().getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);

        } catch (Exception e) {
            e.printStackTrace();
        }

        personRepository.save(queryMsg);
    }
}
