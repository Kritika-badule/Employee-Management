package servTest;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.ERP.EmployeeManagement.model.modelEmployee;
import com.ERP.EmployeeManagement.repository.repositoryEmployee;
import com.ERP.EmployeeManagement.service.*;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;

class serviceEmployeeTest {

	    @Mock
	    private repositoryEmployee repository; 

	    @InjectMocks
	    private serviceEmployee service;  


	    @Test
	    void GetEmployee() {
	       
	        modelEmployee  employee1 = new modelEmployee();
	        modelEmployee employee2 = new modelEmployee();
	        
	        when(repository.findAll()).thenReturn(List.of(employee1));
	        var modelEmployee = service.getAll();
	        assertThat(modelEmployee).isNotNull();
	        
	}

	

}
