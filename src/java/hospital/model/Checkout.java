/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yerzhan
 */
@Entity
@Table(name = "checkouts")
@NamedQueries({
    @NamedQuery(name = "Checkout.findAll", query = "SELECT c FROM Checkout c")})
public class Checkout implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Column(name = "out_clinic_disease_date")
    @Temporal(TemporalType.DATE)
    private Date outClinicDiseaseDate;
    @Column(name = "to_hospital_directed_date")
    @Temporal(TemporalType.DATE)
    private Date toHospitalDirectedDate;
    @Column(name = "hospital_entrance_date")
    @Temporal(TemporalType.DATE)
    private Date hospitalEntranceDate;
    @Size(max = 2147483647)
    @Column(name = "hospital_retirement_date")
    private String hospitalRetirementDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "full_diagnosis")
    private String fullDiagnosis;
    @Size(max = 2147483647)
    @Column(name = "brief_history")
    private String briefHistory;
    @Size(max = 2147483647)
    private String recommendations;
    @Basic(optional = false)
    @NotNull
    @Column(name = "checkedout_on")
    @Temporal(TemporalType.DATE)
    private Date checkedoutOn;
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @ManyToOne
    private Patient patientId;
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @ManyToOne
    private Doctor doctorId;

    public Checkout() {
    }

    public Checkout(Integer id) {
        this.id = id;
    }

    public Checkout(Integer id, String fullDiagnosis, Date checkedoutOn) {
        this.id = id;
        this.fullDiagnosis = fullDiagnosis;
        this.checkedoutOn = checkedoutOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOutClinicDiseaseDate() {
        return outClinicDiseaseDate;
    }

    public void setOutClinicDiseaseDate(Date outClinicDiseaseDate) {
        this.outClinicDiseaseDate = outClinicDiseaseDate;
    }

    public Date getToHospitalDirectedDate() {
        return toHospitalDirectedDate;
    }

    public void setToHospitalDirectedDate(Date toHospitalDirectedDate) {
        this.toHospitalDirectedDate = toHospitalDirectedDate;
    }

    public Date getHospitalEntranceDate() {
        return hospitalEntranceDate;
    }

    public void setHospitalEntranceDate(Date hospitalEntranceDate) {
        this.hospitalEntranceDate = hospitalEntranceDate;
    }

    public String getHospitalRetirementDate() {
        return hospitalRetirementDate;
    }

    public void setHospitalRetirementDate(String hospitalRetirementDate) {
        this.hospitalRetirementDate = hospitalRetirementDate;
    }

    public String getFullDiagnosis() {
        return fullDiagnosis;
    }

    public void setFullDiagnosis(String fullDiagnosis) {
        this.fullDiagnosis = fullDiagnosis;
    }

    public String getBriefHistory() {
        return briefHistory;
    }

    public void setBriefHistory(String briefHistory) {
        this.briefHistory = briefHistory;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public Date getCheckedoutOn() {
        return checkedoutOn;
    }

    public void setCheckedoutOn(Date checkedoutOn) {
        this.checkedoutOn = checkedoutOn;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checkout)) {
            return false;
        }
        Checkout other = (Checkout) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hospital.model.Checkout[ id=" + id + " ]";
    }
    
}
