package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseStructure;
import com.example.demo.entities.Cargo;
import com.example.demo.entities.Carrier;
import com.example.demo.entities.Loading;
import com.example.demo.entities.Orders;
import com.example.demo.entities.Truck;
import com.example.demo.entities.Unloading;
import com.example.demo.entities.Users;
import com.example.demo.service.CargoService;
import com.example.demo.service.CarrierService;
import com.example.demo.service.DriverService;
import com.example.demo.service.LoadingService;
import com.example.demo.service.OrderService;
import com.example.demo.service.TruckService;
import com.example.demo.service.UnloadingService;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private TruckService truckService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private CargoService cargoService;

	@Autowired
	private CarrierService carrierService;

	@Autowired
	private DriverService driverService;

	@Autowired
	private LoadingService loadingService;

	@Autowired
	private UnloadingService unloadingService;

	// Below are crud operations on user

	@PostMapping
	public ResponseEntity<ResponseStructure<Users>> saveUser(@Valid @RequestBody Users user, @CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return userService.saveUser(user);
		}

		return new ResponseEntity<ResponseStructure<Users>>(HttpStatus.FORBIDDEN);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<Users>> getUserById(@Valid @PathVariable int id, @CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return userService.getUserById(id);
		}

		return new ResponseEntity<ResponseStructure<Users>>(HttpStatus.FORBIDDEN);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<Users>> deleteUser(@Valid @PathVariable int id, @CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return userService.deleteUser(id);
		}
		return new ResponseEntity<ResponseStructure<Users>>(HttpStatus.FORBIDDEN);

	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Users>> findAll(@Valid @CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return userService.findall();
		}

		return new ResponseEntity<ResponseStructure<Users>>(HttpStatus.FORBIDDEN);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<Users>> updateUser(@Valid @RequestBody Users user, @CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return userService.updateUser(user);
		}

		return new ResponseEntity<ResponseStructure<Users>>(HttpStatus.FORBIDDEN);
	}

	// controller to save truck data
	@PostMapping("/truck")
	public ResponseEntity<ResponseStructure<Truck>> saveTruck(@Valid @RequestBody Truck truck, @CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return truckService.saveTruck(truck);
		}

		return new ResponseEntity<ResponseStructure<Truck>>(HttpStatus.FORBIDDEN);
	}

	// controller to save order
	@PostMapping("/order")
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(@Valid @RequestBody Orders order,
			@CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return orderService.saveOrder(order);
		}

		return new ResponseEntity<ResponseStructure<Orders>>(HttpStatus.FORBIDDEN);
	}

	// controller to save cargo
	@PostMapping("/cargo")
	public ResponseEntity<ResponseStructure<Cargo>> saveCargo(@Valid @RequestBody Cargo cargo, @CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return cargoService.saveCargo(cargo);
		}

		return new ResponseEntity<ResponseStructure<Cargo>>(HttpStatus.FORBIDDEN);
	}

	// controller to save carrier
	@PostMapping("/carrier")
	public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(@Valid @RequestBody Carrier carrier,
			@CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return carrierService.saveCarrier(carrier);
		}

		return new ResponseEntity<ResponseStructure<Carrier>>(HttpStatus.FORBIDDEN);

	}

	// controller to save loading
	@PostMapping("/loading")
	public ResponseEntity<ResponseStructure<Loading>> saveLoading(@Valid @RequestBody Loading loading,
			@CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return loadingService.saveLoading(loading);
		}

		return new ResponseEntity<ResponseStructure<Loading>>(HttpStatus.FORBIDDEN);

	}

	// controller to save unloading
	@PostMapping("/unloading")
	public ResponseEntity<ResponseStructure<Unloading>> saveUnloading(@Valid @RequestBody Unloading loading,
			@CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return unloadingService.saveUnloading(loading);
		}

		return new ResponseEntity<ResponseStructure<Unloading>>(HttpStatus.FORBIDDEN);
	}

	// controller to modify the order
	@PutMapping("/order")
	public ResponseEntity<ResponseStructure<Orders>> updateOrder(@Valid @RequestBody Orders order,
			@CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return orderService.saveOrder(order);
		}

		return new ResponseEntity<ResponseStructure<Orders>>(HttpStatus.FORBIDDEN);

	}

	// controller to view all the orders
	@GetMapping("/allorders")
	public ResponseEntity<ResponseStructure<Orders>> getAllOrders(@Valid @CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return orderService.findAllOrders();
		}

		return new ResponseEntity<ResponseStructure<Orders>>(HttpStatus.FORBIDDEN);
	}

	// controller to edit the carrier
	@PutMapping("/editcarrier")
	public ResponseEntity<ResponseStructure<Carrier>> updateCarrier(@Valid @RequestBody Carrier carrier,
			@CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return carrierService.saveCarrier(carrier);
		}

		return new ResponseEntity<ResponseStructure<Carrier>>(HttpStatus.FORBIDDEN);
	}

	// controller to edit the loading point
	@PutMapping("/editloading")
	public ResponseEntity<ResponseStructure<Loading>> updateLoading(@Valid @RequestBody Loading loading,
			@CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return loadingService.saveLoading(loading);
		}

		return new ResponseEntity<ResponseStructure<Loading>>(HttpStatus.FORBIDDEN);
	}

	// controller to edit the unloading point
	@PutMapping("/editunloading")
	public ResponseEntity<ResponseStructure<Unloading>> updateUnloading(@Valid @RequestBody Unloading unloading,
			@CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return unloadingService.saveUnloading(unloading);
		}
  
		return new ResponseEntity<ResponseStructure<Unloading>>(HttpStatus.FORBIDDEN);
	}

	// controller to delete the order
	@DeleteMapping("/order/{id}")
	public ResponseEntity<ResponseStructure<Orders>> deleteOrders(@Valid @PathVariable int id, @CookieValue String userRole) {
		if (userRole.equals("ADMIN")) {
			return orderService.deleteOrder(id);
		}
		return new ResponseEntity<ResponseStructure<Orders>>(HttpStatus.FORBIDDEN);
	}

//	//controller to update carrier id
//	@PutMapping("/{id}")
//	public ResponseEntity<ResponseStructure<String>> updateCarrierId(@PathVariable int id)
//	{
//		return driverService.updateById(id);
//	}
}
