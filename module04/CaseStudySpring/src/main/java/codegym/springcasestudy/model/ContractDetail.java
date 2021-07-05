package codegym.springcasestudy.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractDetailId;
    @ManyToOne
    @JoinColumn(name = "attachService_id")
    private AttachService attachService;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
    private int quantity;

    public ContractDetail() {
    }

    public Long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
