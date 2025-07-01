#include <iostream>
#include <vector>
#include <sstream>
#include <string>

std::vector<int> split_to_int(std::string str, char delimiter) {
	std::istringstream ss(str);
	std::string buffer;

	std::vector<int> result;

	while (std::getline(ss, buffer, delimiter)) {
		result.push_back(std::stoi(buffer));
	}

	return result;
}

long long max(std::vector<int> points) {
	long long max = 0;
	for (int i = 0; i < points.size(); ++i) {
		if (points[i] > max) {
			max = points[i];
		}
	}
	return max;
}

void solve() {
	long long sum = 0;
	std::string val;
	getline(std::cin, val);

	for (int i = 0; i < 2; ++i) {
		std::getline(std::cin, val);
		std::vector<int> points = split_to_int(val, ' ');
		sum += max(points);
	}

	std::cout << sum;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}