module jmp.app {
    uses com.epam.jmp.service.Service;

    requires jmp.dto;
    requires jmp.bank.api;
    requires jmp.cloud.bank.impl;
    requires jmp.cloud.service.impl;

}