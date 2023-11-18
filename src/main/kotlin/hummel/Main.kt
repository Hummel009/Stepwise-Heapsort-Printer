package hummel

fun main() {
	val arr = intArrayOf(8, 4, 8, 13, 1, 10, 9, 5, 7, 6, 11, 14, 2, 12, 15)

	println("Start array is")
	printArray(arr)

	sort(arr)

	println("Final array is")
	printArray(arr)
}

fun sort(arr: IntArray) {
	val n = arr.size
	println()
	println("Making heap")
	for (i in n / 2 - 1 downTo 0) {
		heapify(arr, n, i)
		printArray(arr)
		println()
	}
	println()
	println("Taking elements")
	for (i in n - 1 downTo 0) {
		val temp = arr[0]
		arr[0] = arr[i]
		arr[i] = temp
		println("N = $i; Swap(Arr[0], Arr[N])")
		println("Arr[0] = ${arr[0]}; Arr[N] = ${arr[i]}")
		printArray(arr)
		heapify(arr, i, 0)
		printArray(arr)
		println()
	}
}

private fun heapify(arr: IntArray, n: Int, i: Int) {
	var max = i
	val l = 2 * i + 1
	val r = 2 * i + 2
	var flag = true
	println("I = ${i}; Arr[I] = ${arr[i]}")
	println("L = $l; R = $r; Max = $max")
	if (l < n && r < n) {
		println("Arr[L] = ${arr[l]}; Arr[R] = ${arr[r]}; Arr[Max] = ${arr[max]}")
	} else {
		if (n in (r + 1)..l) {
			println("L >= $n")
		} else if (l < n) {
			println("R >= $n")
		} else {
			println("L >= $n; R >= $n")
		}
		flag = false
	}
	if (l < n && arr[l] > arr[max]) {
		println("Arr[L] > Arr[Max] => Max = L = ${l}; Arr[Max] = ${arr[l]}")
		max = l
	} else if (flag) {
		println("Arr[L] < Arr[Max]")
	}
	if (r < n && arr[r] > arr[max]) {
		println("Arr[R] > Arr[Max] => Max = R = ${r}; Arr[Max] = ${arr[r]}")
		max = r
		println("Arr[Max] = " + arr[max])
	} else if (flag) {
		println("Arr[R] < Arr[Max]")
	}
	if (max != i) {
		println("Max <> I => Swap(Arr[I], Arr[Max])")
		val swap = arr[i]
		arr[i] = arr[max]
		arr[max] = swap
		printArray(arr)
		heapify(arr, n, max)
	} else {
		println("Max = I")
	}
}

fun printArray(arr: IntArray) {
	for (j in arr) {
		print("$j ")
	}
	println()
}