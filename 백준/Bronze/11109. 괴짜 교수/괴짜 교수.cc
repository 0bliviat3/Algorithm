#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

std::vector<int> split_to_int(std::string str, char delimiter) {
	std::istringstream ss(str);
	std::string buffer;

	std::vector<int> result;

	while (std::getline(ss, buffer, delimiter)) {
		result.push_back(std::stoi(buffer));
	}

	return result;
}

void solve() {

	int n;
	std::cin >> n;
	while (n--) {
		int d, n, s, p;
		std::cin >> d >> n >> s >> p;
		int parallel = d + n * p;
		int single = n * s;
		if (parallel < single) {
			std::cout << "parallelize " << "\n";
		} else if (single < parallel) {
			std::cout << "do not parallelize " << "\n";
		} else {
			std::cout << "does not matter " << "\n";
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}