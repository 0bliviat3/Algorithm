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

int sum_point(std::vector<int> points) {
	int sum = 0;
	for (int i = 0; i < points.size(); ++i) {
		sum += (points[i] * (i + 1));
	}
	return sum;
}

void solve() {
	int sum[2];
	std::string val;
	
	for (int i = 0; i < 2; ++i) {
		std::getline(std::cin, val);
		std::vector<int> points = split_to_int(val, ' ');
		sum[i] = sum_point(points);
	}

	if (sum[0] > sum[1]) {
		std::cout << "1\n";
	} else if (sum[0] < sum[1]) {
		std::cout << "2\n";
	} else {
		std::cout << "0\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}