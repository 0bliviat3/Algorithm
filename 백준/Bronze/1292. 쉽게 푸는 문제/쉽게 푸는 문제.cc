#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

void solve() {

	int arr[1001] = { 0, };

	int idx = 1;
	int num = 1;
	while (idx <= 1000) {
		for (int i = 0; i < num && idx <= 1000; i++) {
			arr[idx] = num + arr[idx - 1];
			idx++;
		}
		num++;
	}

	int a, b;
	std::cin >> a >> b;

	std::cout << arr[b] - arr[a - 1];

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}