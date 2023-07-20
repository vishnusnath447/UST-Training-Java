package in.stackroute.dto;

import in.stackroute.domain.Address;

public record CustomerDto(int customerId, String customerName, AddressDto homeAddress,AddressDto workAddress) {
}
