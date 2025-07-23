#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

void solve() {

	int n, cnt = 0;
	char x;
	std::cin >> n;

	std::vector<char> arr;

	for (int i = 0; i < n; ++i) {
		std::cin >> x;
		arr.push_back(x);
	}

	for (int i = 0; i < n; ++i) {
		std::cin >> x;
		if (x == arr[i]) {
			cnt++;
		}
	}

	std::cout << cnt;


}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}