#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

static int arr[1000001] = { 0, };

void solve() {
	
	arr[0] = 1;
	for (int i = 1; i < 1000001; i++) {
		arr[i] = arr[i - 1];
		int num = i;
		while (num) {
			if (num % 10 == 0) {
				arr[i]++;
			}
			num /= 10;
		}
	}

	int n;
	std::cin >> n;
	while (n--) {
		int a, b;
		std::cin >> a >> b;
		std::cout << arr[b] - (a == 0 ? 0 : arr[a - 1]) << "\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}