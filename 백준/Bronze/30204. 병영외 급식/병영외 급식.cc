#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>


void solve() {

	int n, m;
	std::cin >> n >> m;

	int sum = 0;
	while (n--) {
		int now;
		std::cin >> now;
		sum += now;
	}

	if (sum % m == 0) {
		std::cout << 1;
	}
	else {
		std::cout << 0;
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}