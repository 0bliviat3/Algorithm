#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void convertBinary(int num, int* arr) {
	for (int i = 0; i < 10; i++) {
		arr[i] = num % 2;
		num /= 2;
	}
}

void convertDecimal(int* arr, int& num) {
	num = 0;
	for (int i = 9; i >= 0; i--) {
		num = num * 2 + arr[i];
	}
}

void solve() {

	int a, b;
	int a_arr[10], b_arr[10], c_arr[10] = { 0 };
	std::cin >> a >> b;
	convertBinary(a, a_arr);
	convertBinary(b, b_arr);
	for (int i = 0; i < 10; i++) {
		c_arr[i] = a_arr[i] ^ b_arr[i];
	}
	int c;
	convertDecimal(c_arr, c);
	std::cout << c;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}