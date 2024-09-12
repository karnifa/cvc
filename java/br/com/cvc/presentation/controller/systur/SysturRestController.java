package br.com.cvc.presentation.controller.systur;

import br.com.cvc.core.boundary.input.systur.*;
import br.com.cvc.core.util.GenerateUuidUtils;
import br.com.cvc.presentation.mapper.systur.*;
import br.com.cvc.presentation.model.systur.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/systur")
@RequiredArgsConstructor

public final class SysturRestController implements SysturAPI {

	private final FindAllBranchesBoundary findAllBranchesBoundary;
	private final FindAllCitiesByCountryIdAndStateIdBoundary findAllCitiesByCountryIdAndStateIdBoundary;
	private final FindAllCountriesBoundary findAllCountriesBoundary;
	private final FindAllOperationsBoundary findAllOperationsBoundary;
	private final FindAllPackageGroupsBoundary findAllPackageGroupsBoundary;
	private final FindAllProdutsBoundary findAllProdutsBoundary;
	private final FindAllStatesByCountryIdBoundary findAllStatesByCountryIdBoundary;
	private final FindAllSuppliersByParamsBoundary findAllSuppliersByParamsBoundary;
	private final FindAllSystemsBoundary findAllSystemsBoundary;
	private final BranchResponseModelMapper branchResponseModelMapper;
	private final CityResponseModelMapper cityResponseModelMapper;
	private final CountryResponseModelMapper countryResponseModelMapper;
	private final OperationResponseModelMapper operationResponseModelMapper;
	private final PackageGroupResponseModelMapper packageGroupResponseModelMapper;
	private final ProductResponseModelMapper productResponseModelMapper;
	private final StateResponseModelMapper stateResponseModelMapper;
	private final SupplierResponseModelMapper supplierResponseModelMapper;
	private final SystemResponseModelMapper systemResponseModelMapper;

	@Override
	@GetMapping(path = "/v1/branch/all")
	@ResponseStatus(HttpStatus.OK)
	public List<BranchResponseModel> findAllBranches() {
		final var uuid = GenerateUuidUtils.execute();
		return this.findAllBranchesBoundary.execute(uuid)
				.stream()
				.map(this.branchResponseModelMapper::dtoToModel)
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping(path = "/v1/city")
	@ResponseStatus(HttpStatus.OK)
	public List<CityResponseModel> findAllCities(@RequestParam String country, @RequestParam String state) {
		final var uuid = GenerateUuidUtils.execute();
		return this.findAllCitiesByCountryIdAndStateIdBoundary.execute(country, state, uuid)
				.stream()
				.map(this.cityResponseModelMapper::dtoToModel)
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping(path = "/v1/country/all")
	@ResponseStatus(HttpStatus.OK)
	public List<CountryResponseModel> findAllCountries() {
		final var uuid = GenerateUuidUtils.execute();
		return this.findAllCountriesBoundary.execute(uuid)
				.stream()
				.map(this.countryResponseModelMapper::dtoToModel)
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping(path = "/v1/operation/all")
	@ResponseStatus(HttpStatus.OK)
	public List<OperationResponseModel> findAllOperations() {
		final var uuid = GenerateUuidUtils.execute();
		return this.findAllOperationsBoundary.execute(uuid)
				.stream()
				.map(this.operationResponseModelMapper::dtoToModel)
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping(path = "/v1/package-group/all")
	@ResponseStatus(HttpStatus.OK)
	public List<PackageGroupResponseModel> findAllPackageGroups() {
		final var uuid = GenerateUuidUtils.execute();
		return this.findAllPackageGroupsBoundary.execute(uuid)
				.stream()
				.map(this.packageGroupResponseModelMapper::dtoToModel)
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping(path = "/v1/product/all")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponseModel> findAllProducts() {
		final var uuid = GenerateUuidUtils.execute();
		return this.findAllProdutsBoundary.execute(uuid)
				.stream()
				.map(this.productResponseModelMapper::dtoToModel)
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping(path = "/v1/state")
	@ResponseStatus(HttpStatus.OK)
	public List<StateResponseModel> findAllStatesByCountryId(@RequestParam String country) {
		final var uuid = GenerateUuidUtils.execute();
		return this.findAllStatesByCountryIdBoundary.execute(country, uuid)
				.stream()
				.map(this.stateResponseModelMapper::dtoToModel)
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping(path = "/v1/supplier/all")
	@ResponseStatus(HttpStatus.OK)
	public List<SupplierResponseModel> findAllSupplierByParams() {
		final var uuid = GenerateUuidUtils.execute();
		return this.findAllSuppliersByParamsBoundary.execute(uuid)
				.stream()
				.map(this.supplierResponseModelMapper::dtoToModel)
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping(path = "/v1/system/all")
	@ResponseStatus(HttpStatus.OK)
	public List<SystemResponseModel> findAllSystems() {
		final var uuid = GenerateUuidUtils.execute();
		return this.findAllSystemsBoundary.execute(uuid)
				.stream()
				.map(this.systemResponseModelMapper::dtoToModel)
				.collect(Collectors.toList());
	}
}
