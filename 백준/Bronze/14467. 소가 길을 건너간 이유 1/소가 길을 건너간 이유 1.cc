#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

void solve() {

	int n;
	std::cin >> n;

	int arr[11] = { 0, };
	int cnt = 0;

	while (n--) {
		int a, b;
		std::cin >> a >> b;

		if (arr[a] == 0) {
			arr[a] = b + 1;
		} else if (arr[a] != b + 1) {
			arr[a] = b + 1;
			cnt++;
		}
	}

	std::cout << cnt << "\n";

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}