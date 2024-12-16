package com.akdriss.cvback.mappers;
import com.akdriss.cvback.dtos.ContactDto;
import com.akdriss.cvback.entities.Contact;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContactMapper implements GenericMapper<Contact, ContactDto> {
    @Override
    public ContactDto toDto(Contact contact) {
        return new ContactDto(contact.getEmail(), contact.getPhone(), contact.getAddress());
    }

    @Override
    public Contact toEntity(ContactDto contactDto) {
        Contact contact=new Contact();
        contact.setAddress(contactDto.getAddress());
        contact.setEmail(contactDto.getEmail());
        contact.setPhone(contactDto.getPhone());
        return contact;
    }

    @Override
    public List<ContactDto> toListDto(List<Contact> contacts) {

        return contacts.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Contact> toListEntities(List<ContactDto> contactDtos) {
        return contactDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
