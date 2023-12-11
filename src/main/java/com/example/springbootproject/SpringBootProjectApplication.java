package com.example.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootApplication
public class SpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}

}
class SortResponse {
	private List<List<Integer>> sortedArrays;
	private long timeNs;

	public SortResponse(List<List<Integer>> sortedArrays, long timeNs) {
		this.sortedArrays = sortedArrays;
		this.timeNs = timeNs;
	}

	public List<List<Integer>> getSortedArrays() {
		return sortedArrays;
	}

	public long getTimeNs() {
		return timeNs;
	}
}

@RestController
@RequestMapping("/api")
class SortingController {


	@GetMapping("")
	public String testing() {
		return "This is Working";
	}

	@PostMapping("/process-single")
	public ResponseEntity<SortResponse> processSingle(@RequestBody MapRequestBody request) {
		long startTime = System.nanoTime();


		List<List<Integer>> sortedArrays = new ArrayList<>();
		for (List<Integer> subArray : request.getToSort()) {
			List<Integer> sortedSubArray = new ArrayList<>(subArray);
			sortedSubArray.sort(null);
			sortedArrays.add(sortedSubArray);
		}

		long elapsedTime = System.nanoTime() - startTime;

		SortResponse response = new SortResponse(sortedArrays, elapsedTime);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/process-concurrent")
	public ResponseEntity<SortResponse> processConcurrent(@RequestBody MapRequestBody request) {
		long startTime = System.nanoTime();

		List<List<Integer>> sortedArrays = new ArrayList<>();
		ExecutorService executorService = Executors.newFixedThreadPool(request.getToSort().size());

		List<Future<List<Integer>>> futures = new ArrayList<>();
		for (List<Integer> subArray : request.getToSort()) {
			futures.add(executorService.submit(() -> {
				List<Integer> sortedSubArray = new ArrayList<>(subArray);
				sortedSubArray.sort(null);
				return sortedSubArray;
			}));
		}

		for (Future<List<Integer>> future : futures) {
			try {
				sortedArrays.add(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		executorService.shutdown();

		long elapsedTime = System.nanoTime() - startTime;

		SortResponse response = new SortResponse(sortedArrays, elapsedTime);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}

class MapRequestBody {
	private List<List<Integer>> toSort;

	public List<List<Integer>> getToSort() {
		return toSort;
	}

	public void setToSort(List<List<Integer>> toSort) {
		this.toSort =toSort;
	}
}
