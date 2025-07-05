#include <iostream>
#include <vector>
#include <sstream>
#include <string>

void solve() {
	int n;
	std::cin >> n;
	std::cin.ignore();
	

	std::cout << ((n * (n + 1) * (n + 2)) >> 1);
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}