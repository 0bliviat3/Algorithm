#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	int n;
	std::string input;
	const std::string GORI = "gori";

	std::cin >> n;
	std::cin.ignore();
	std::getline(std::cin, input);
	
	if (input.find(GORI) == std::string::npos) {
		std::cout << "NO" << std::endl;
		return;
	}
	std::cout << "YES" << std::endl;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}