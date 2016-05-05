/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.web;

import hospital.data.Bean;
import hospital.data.CheckoutBean;
import hospital.model.Checkout;
import hospital.model.Doctor;
import hospital.web.event.PatientEvent;
import hospital.web.event.Selection;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author yerzhan
 */
@Named
@SessionScoped
public class Checkouts extends Controller<Checkout> {

    @Inject
    private CheckoutBean bean;

    @Override
    protected Bean getBean() {
        return bean;
    }

    public void patientSelected(@Observes @Selection PatientEvent event) {
        items = null;
        setSelected(null);
    }

    @Override
    public List<Checkout> getItems() {
        if (items == null) {
            items = bean.find(patients.getSelected());
        }
        return items;
    }

    @Inject
    private Authentication authentication;

    private final Doctor doctor = authentication.getDoctor();

    @Inject
    private Patients patients;

    @Override
    protected Checkout createEntity() {
        Checkout checkout = new Checkout();
        checkout.setDoctor(doctor);
        checkout.setPatient(patients.getSelected());
        return checkout;
    }

}
