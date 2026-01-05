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

	if (n % 3 == 0 || m % 3 == 0) {
		std::cout << "YES\n";
	}
	else {
		std::cout << "NO\n";
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}