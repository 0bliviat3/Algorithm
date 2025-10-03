#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int arr[11] = { 0 };
	for (int i = 0; i <= 10; i++) {
		std::cin >> arr[i];
	}
	int n;
	int sum = 0;
	std::cin >> n;
	while (n--) {
		int a, c;
		double b;
		std::cin >> a >> b >> c;
		if (b >= 2.0 && c >= 17) {
			sum += arr[a];
		}
	}
	std::cout << sum;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}